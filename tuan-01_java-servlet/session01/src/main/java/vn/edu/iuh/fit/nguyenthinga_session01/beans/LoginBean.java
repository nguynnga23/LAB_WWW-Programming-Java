package vn.edu.iuh.fit.nguyenthinga_session01.beans;

public class LoginBean {
    /**+
     *
     * @param username
     * @param password
     * @return
     */
    public boolean login(String username, String password){
        if(username.equalsIgnoreCase("ty") && password.equals("123"))
            return true;
        return false;
    }
}
