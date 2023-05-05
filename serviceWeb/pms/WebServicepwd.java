
package pms;
import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
public class WebServicepwd {
    @Path("/generatePwd")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String generatePwd(@FormParam("longueurMotDePasse") String longueurMotDePasse, @FormParam("chkMajuscules") String chkMajuscules, @FormParam("chkChiffres") String chkChiffres,@FormParam("selectForce") String forcePwd, @FormParam("chkCaracteresSpeciaux") String chkCaracteresSpeciaux){
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
        switch(forcePwd){
            case "faible":
                return (generateur.genererFaibleMotDepasse(chiffre,Speaciaux));
            case "moyen":
                return(generateur.generateMotPasseMoyen(chiffre,Speaciaux));
            case "fort":
                return(generateur.generateMotPasseRenforce(chiffre,Speaciaux,majiscule));
            case "tresFort":
                return (generateur.generateMotPasseFort(chiffre,Speaciaux,majiscule));
            default:
                return (generateur.generateMotPasse(Integer.parseInt(longueurMotDePasse), chiffre, majiscule,Speaciaux));
        }



    }
    
   

}