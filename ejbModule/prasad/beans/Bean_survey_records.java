package prasad.beans;

import java.util.ArrayList;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import prasad.DBConnect.DatabaseConnection;



/**
 * Session Bean implementation class Students_Records_EJB
 */

@Stateless
//@EJB(mappedName="Students_Records_EJB")


public class Bean_survey_records implements Bean_remote_records{

	@Override
	public ArrayList<Bean_surey> getStudentRecords(Bean_surey dataBean) {
		// TODO Auto-generated method stub
		return DatabaseConnection.getSurveyRecords(dataBean);
		
	}

	@Override
	public void insertStudentRecord(Bean_surey dataBean) {
		// TODO Auto-generated method stub
		DatabaseConnection.insertSurveyRecords(dataBean);
		
	}

	@Override
	public String getClientString(String client) {
		// TODO Auto-generated method stub
		return client + " - from local session bean";
		
	}
	

}
