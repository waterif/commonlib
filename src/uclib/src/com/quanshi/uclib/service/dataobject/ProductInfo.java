package com.quanshi.uclib.service.dataobject;

import java.util.List;

public class ProductInfo
{

	public static class Component
	{
		public static class Porperty
		{
			public Integer yunPanType;
			public Integer addSpace;
			public Integer addMember;
			public Integer yunPanVisible;
			public Integer im;
			public Integer calendar;
			public Integer conf;
			public String call;
			public Integer appCenter;
			public Integer appMoments;
			public Integer scan;
			public Long beeVersion;
			public Integer pbx;
			public String addressBook;
			public String videoConferenceRoom;
			public String broadcastingStation;
		}

		public int id;
		public String name;
		public String activationUrl;
		public Porperty property;
	}

	public int id;
	public int productId;
	public List<Component> components;

}
