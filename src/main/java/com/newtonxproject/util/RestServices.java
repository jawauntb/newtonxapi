package com.newtonxproject.util;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import com.newtonxproject.beans.User;


/* get_all_users; get_user_by_name; get_user_by_id; post_new_user(JSON); 
 * post firname lasname; create id; use RESTEasy; send to __ sql
*/

@ApplicationPath("/restapi")
public class RestServices extends Application {

    private Set<Object> singletons = new HashSet<Object>();

    public RestServices() {
        singletons.add(new UserCrudService());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

    @Override
    public Set<Class<?>> getClasses() {
        return super.getClasses();
    }

    @Override
    public Map<String, Object> getProperties() {
        return super.getProperties();
    }
}