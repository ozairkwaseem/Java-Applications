public class Project {

    public String name;
    public String description;

    public void elevatorPitch(String ProjectName, String ProjectDescription){
        this.name= ProjectName;
        this.description = ProjectDescription;

        System.out.println("Name: " + ProjectName +  "Description: " + ProjectDescription );
    }

    public Project() {
    }

    public Project(String name) {
    }

    public Project(String name, String description) {
    }

    public void setName(String name) {
        this.name= name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description= description;
    }

    public String getDescription() {
        return description;
    }

}