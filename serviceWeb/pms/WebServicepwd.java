
package pms;
import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
public class WebServicepwd {
    @Path("/generatePwd")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String generatePwd(@FormParam("longueurMotDePasse") String longueurMotDePasse, @FormParam("chkMajuscules") String chkMajuscules, @FormParam("chkChiffres") String chkChiffres, @FormParam("chkCaracteresSpeciaux") String chkCaracteresSpeciaux){
        Boolean majiscule=false;
        Boolean chiffre=false;
        Boolean Speaciaux=false;
        if (chkMajuscules!=null){
            majiscule=true;
        }
        if (chkChiffres!=null){
            chiffre=true;
        }
        if (chkCaracteresSpeciaux!=null){
            Speaciaux=true;
        }
        GenerateMotPass generateur= new GenerateMotPass();

        return (generateur.generateMotPasse(Integer.parseInt(longueurMotDePasse), chiffre, majiscule,Speaciaux));
    }
    
   

}