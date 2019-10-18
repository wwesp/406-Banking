package Accounts.People;

import org.json.JSONException;
import org.json.JSONObject;

abstract public class People {
    String ssn;
    String fName;
    String lName;



    public People(String ssn, String fName, String lName){
        this.ssn = ssn;
        this.fName = fName;
        this.lName = lName;
    }

    public String getSsn() {
        return ssn;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public JSONObject getJSON(){
        JSONObject obj = new JSONObject();

        try{
            obj.put("ssn",ssn);
            obj.put("fName",fName);
            obj.put("lName",lName);
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return obj;
    }

}
