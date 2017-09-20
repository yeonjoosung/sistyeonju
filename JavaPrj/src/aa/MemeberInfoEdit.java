package aa;


import java.util.Date;

public class MemeberInfoEdit
{
   private String name;
   private String dogname;
   private int dogage;
   private Date joinDate;
   private String abc;

   public MemeberInfoEdit()
   {
   }

   public MemeberInfoEdit(String name, String dogname, int dogage, Date joinDate, String abc) 
   {
      this.name = name;
      this.dogname = dogname;
      this.dogage = dogage;
      this.joinDate = joinDate;
      this.abc = abc;
   }

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDogname() {
	return dogname;
}

public void setDogname(String dogname) {
	this.dogname = dogname;
}

public int getDogage() {
	return dogage;
}

public void setDogage(int dogage) {
	this.dogage = dogage;
}

public Date getJoinDate() {
	return joinDate;
}

public void setJoinDate(Date joinDate) {
	this.joinDate = joinDate;
}

public String getAbc() {
	return abc;
}

public void setAbc(String abc) {
	this.abc = abc;
}

}
