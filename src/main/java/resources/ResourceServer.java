package resources;

/**
 * Created by user
 * on 21.12.2018
 */

public class ResourceServer implements ResourceServerI{

    private TestResource resource;

    public ResourceServer(TestResource resource){
        this.resource = resource;
    }

    public int readAge(){
        return resource.getAge();
    }

    public String readName(){
        return resource.getName();
    }

    public void setResource(TestResource resource) {
        this.resource = resource;
    }
}
