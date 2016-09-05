package com.quanshi.uclib.service.dataobject;

import java.util.List;

public class PbxOpenArgs extends PbxAccessAuth
{
	public class UserOptions
	{
		public String userFlag;

		public String easiioPstn = "1";

		public String cityCall = "1";

		public String nationalCall = "1";

		public String internationalCall = "1";

	}

	public UserOptions userOptions;

	public List<PbxUserNames> userNames;

	public PbxOpenArgs()
	{
		userOptions = new UserOptions();
	}

}
