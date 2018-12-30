package resources;

/**
 * Created by user
 * on 21.12.2018
 */

public class ResourceServerController implements ResourceServerControllerMBean {

    private final ResourceServerI resourceServer;

    public ResourceServerController (ResourceServer resourceServer){
        this.resourceServer = resourceServer;
    }

    public int getAge(){
        return resourceServer.readAge();
    }

    public String getName(){
        return resourceServer.readName();
    }

}
