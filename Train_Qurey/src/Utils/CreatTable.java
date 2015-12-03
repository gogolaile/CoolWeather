package Utils;

public class CreatTable {
	public static void createtable(){
		try{
			String sql[] = new String[]{
					"create table if not exists train" +
					"(Tid integer primary key,Tname char (20),"+
					"Tstartstation char(20),Tterminus char(20),Ttype char(20))",
				    "create table if not exists station(Sid integer primary key,"+
					"Sname char(20),Spy char(10))",
					"create table if not exists relation"+
					"(Rid integer primary key,Tid integer,Sid integer,Rarrivetime char(20),"+
							"Rstarttime char(20))",
		};
			for(String o:sql){
				Utils.LoadUtil.createTable(o);
			}
			}catch(Exception e){
			e.printStackTrace();
		}
	}
}
