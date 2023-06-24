package com.techCamp.backend.service;

public class Eval {
    private String separator="[()]";
    private String andSeparator="&";
    private String orSeparator="||";
    private String equalSeparator="=";
    private String greatearSeparator=">";
    private String lesserSeparator="<";

    //Le falta atributo que identifique la tabla en la cual va a trbajar, un titulo o id
    public boolean evaluate(String rule){
        //'''Titulo=Titulo2'&'Fecha=Fecha2''||'Autor=Autor2''
        String[] separate=rule.split(separator);
        return evaluation(separate, true,0);
    }

    public boolean evaluation(String[] ev,boolean is,int index){
        if(index==ev.length){
            //Caso base, final del recorrido
            return true;
        } else if(ev[index].equals("")){
            // Caso No contiene nada
            return evaluation(ev,is,index+1);
        }else return is&compare(ev,is,index)&evaluation(ev,is,index+1);// Caso recursivo
    }

    public boolean compare(String[] ev,boolean is,int index){
        if(ev[index].contains(andSeparator)){
            if(ev[index].equals(andSeparator)){
                System.out.println(ev[index]);
                return is&&evaluation(ev, is, index+1);
            }else{
                //TODO Evaluation AND
                
                System.out.println(ev[index]);
            }
        }else if(ev[index].contains(orSeparator)){
            if(ev[index].equals(orSeparator)){
                
                return is||evaluation(ev, is, index+1);
            }else{
            //TODO Evaluation OR
                System.out.println(ev[index]);
            }
        }else if(ev[index].contains(equalSeparator)){
            //TODO Evaluation EQUAL
            System.out.println(ev[index]);

        }else if(ev[index].contains(greatearSeparator)){
            //TODO Evaluation >
            System.out.println(ev[index]);

        }else if(ev[index].contains(lesserSeparator)){
            //TODO Evaluation <
            System.out.println(ev[index]);

        }else{
            //TODO preparar exeption
            System.out.println(ev[index]);
        }
        ;
        return false;
    }


}
