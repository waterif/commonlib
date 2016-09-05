package com.quanshi.uclib.util;

import java.util.List;
import java.util.Date;

import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;

import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TBinaryProtocol;

import com.gnet.uc.thrift.APIAppEventChangeNotify;
import com.gnet.uc.thrift.APIControlMessageId;
import com.gnet.uc.thrift.APIMessageType;
import com.gnet.uc.thrift.ControlPriType;
import com.gnet.uc.thrift.UcMessageHead;
import com.gnet.uc.thrift.UcMessageBody;
import com.gnet.uc.thrift.AppId;
import com.gnet.uc.thrift.GroupType;
import com.gnet.uc.thrift.ContentType;
import com.gnet.uc.thrift.JID;
import com.quanshi.uclib.dataobject.NewEventNotifyInfo;

public class ThriftHelper
{
	public static final Logger log = LoggerFactory.getLogger( ThriftHelper.class );
	
    private static TSerializer serializer = new TSerializer(new TBinaryProtocol.Factory());

    private static byte[] serializeThrift( UcMessageHead head, UcMessageBody body )
    {
        try
        {
            byte[] bodyBuffer = ( body != null ) ? serializer.serialize( body ) : null;
            head.length = ( bodyBuffer != null ) ? bodyBuffer.length : 0;
            byte[] headBuffer = ( head != null ) ? serializer.serialize( head ) : null;
            if ( null == headBuffer )
            {
                throw new Exception( "headBuffer is null" );
            }

            int totalLen = headBuffer.length + head.length;
			byte[] result = new byte[totalLen];
			
            System.arraycopy(headBuffer, 0, result, 0, headBuffer.length);

			if( head.length > 0 )
            {
				System.arraycopy(bodyBuffer, 0, result, headBuffer.length, head.length);
			}
            else
            {
            	log.info( "body thrift is empty" );
			}

            return result;
        }
        catch( Exception e )
        {
        	log.error( "serializeThrift error:" + e.getMessage() );
            return  null;
        }
    }


    public static byte[] createEventNotify( 
    		int fromUserId, int fromSiteId,
            int toUserId, int toSiteId,
            NewEventNotifyInfo eventNotifyInfo )
    {
    	try
        {
            Date date = new Date();

            UcMessageHead head = new UcMessageHead();
            UcMessageBody body = new UcMessageBody();

            head.appid = (short) AppId.AppAPI.getValue();
            head.pri = (byte) ( ContentType.thrift_type.getValue() | GroupType.to_person.getValue() );
            //通知消息不入库，不做未读计数,需要webpush下发
            head.setControlPri( (byte)ControlPriType.webpush_count_type.getValue() );   
            //head.controlPri = (byte)( ControlPriType.webpush_count_type.getValue() );  
            
            head.protocolid = (short)APIControlMessageId.AppEventChangeNotify.getValue();
            head.protocoltype = (byte)APIMessageType.AppControl.getValue();
            head.id = (int)date.getTime();
            head.seq = 0;
            head.timestamp = 0;
            head.conversation = 0;
            
            JID fromJID = new JID();
            fromJID.userID = eventNotifyInfo.appId;
            fromJID.siteID = fromSiteId;
            head.from = fromJID;

            JID toJID = new JID();
            toJID.userID = toUserId;
            toJID.siteID = toSiteId;
            head.to = toJID;

            APIAppEventChangeNotify eventNotify = new APIAppEventChangeNotify();
            eventNotify.eventCount = eventNotifyInfo.eventCount;
            eventNotify.appId = eventNotifyInfo.appId;
            
            eventNotify.externalData = (null == eventNotifyInfo.extend ) ? "" : eventNotifyInfo.extend;            

            log.debug( "thrftHelper, createEventNotify, eventNotifyInfo.extend: " + eventNotifyInfo.extend );                    
            log.debug("thrift message head : " + head.controlPri + "; " + head.toString() );
            
            body.apiEventNotify = eventNotify;
            
            return serializeThrift( head, body );
        }
        catch( Exception e )
        {
        	log.error( "createAppMsgText fail: " + e.getMessage() );
            return null;
        }
    }
    
    public static byte[] packThriftData( byte[] thrift )
    {
        byte[] res = null;

        if ( null == thrift )
        {
            return res;
        }

        res = MiscUtil.byteArrayLink( res, MiscUtil.int2byte( thrift.length ) );
        res = MiscUtil.byteArrayLink( res, thrift );

        return MiscUtil.compress( res );
    }

    public static byte[] packThriftData( List<byte[]> listThrift )
    {
        byte[] res = null;

        for( byte[] thrift: listThrift )
        {
            if( null == thrift )
            {
                continue;
            }

            res = MiscUtil.byteArrayLink( res, MiscUtil.int2byte( thrift.length ) );
            res = MiscUtil.byteArrayLink( res, thrift );
        }

        if ( null == res )
        {
            return null;
        }

        return MiscUtil.compress( res );
    }
}


