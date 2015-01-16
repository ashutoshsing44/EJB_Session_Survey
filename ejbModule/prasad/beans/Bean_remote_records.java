package prasad.beans;

import java.util.ArrayList;

import javax.ejb.Remote;

@Remote
public interface Bean_remote_records {
	
	 public   ArrayList<Bean_surey> getStudentRecords(Bean_surey dataBean);
	   public void insertStudentRecord(Bean_surey dataBean);
	   public String getClientString(String client);

}