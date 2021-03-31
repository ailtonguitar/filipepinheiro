package solution;

public class UserService {
	 public UserDAO dao;

     public UserService()
     {
         dao = new UserDAO();
     }

     public void Create(User user) throws Exception
     {
         this.dao = new UserDAO();

         user = this.dao.getUserByEmail(user.email);

         this.dao.createUser(user);
     }
}
