/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5;

import tp5.animaux.Animal;
import tp5.animaux.Souris;
import tp5.controler.AbstractControler;
import tp5.controler.Controller;
import tp5.model.AbstractModel;
import tp5.model.Labyrinthe;
import tp5.model.TypeCase;
import tp5.vue.Vue;

/**
 *
 * @author david
 */
public class TP5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AbstractModel model = new Labyrinthe();
        AbstractControler controler = new Controller(model);
        Vue v = new Vue(model,controler);
        model.addObservateur(v);
        v.setVisible(true);
        while(!model.partieTerminer()){
            controler.calculerStepSuivant();
        }
    }
    
}
