/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gsb.rv.dr.technique;

import fr.gsb.rv.dr.entites.Visiteur;

/**
 *
 * @author etudiant
 */
public class Session {
    
    private static Session session=null;
    private Visiteur leVisiteur;
    
    private Session(Visiteur leVisiteur){
        this.leVisiteur=leVisiteur;
        
    }
    
    public static void ouvrir(Visiteur leVisiteur){
        
        Session session=new Session();
        
    }
    
    public static void fermer(){
        Session session=null;
    }

    public Visiteur getLeVisiteur() {
        return leVisiteur;
    }
    
    
    
    public Session() {
    }

    public static Session getSession() {
        return Session.session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean estOuverte(){
        if(session==null){
            return false;
        }
        else{
            return true;
        }
        
    }

    public void setLeVisiteur(Visiteur leVisiteur) {
        this.leVisiteur = leVisiteur;
    }
    
    
}
