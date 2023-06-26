package com.techCamp.backend.service;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.techCamp.backend.model.Rule;
@Service
public class EvalService {
    private String separator="[()]";
    private String andSeparator="&";
    private String orSeparator="\\|\\|";
    private String equalSeparator="=";
    private String greatearSeparator=">";
    private String lesserSeparator="<";
    private RuleService ruleService;
    private TableService tableService;


    public EvalService(RuleService ruleService,TableService tableService){
        this.tableService=tableService;
        this.ruleService=ruleService;
    }


    public boolean evaluate(int idRule,int idTable,String key,String value){
        Rule rule=ruleService.getOne(idRule);
        JSONObject data=tableService.findInBy(idTable, key, value);
        String[] separate=rule.getRule().split(separator);
        
        return compare(separate, true,0,data);
    }

    private boolean compare(String[] ev,boolean is,int index,JSONObject data){
        if(index==ev.length){
            //Caso base, final del recorrido
            return is;
        } else if(ev[index].equals("")){
            // Caso No contiene nada
            return compare(ev,is,index+1,data);
        }else if(ev[index].contains(andSeparator)){
            if(ev[index].equals(andSeparator)){
                return is&&compare(ev, is, index+1, data);
            }else{
                String [] values=ev[index].split(andSeparator);
                boolean value= Boolean.parseBoolean(((String)data.get(values[0])));
                boolean condition=Boolean.parseBoolean(values[1]);
                return compare(ev, is&&value&&condition, index+1, data);
            }
        }else if(ev[index].contains(orSeparator)){
            
            if(ev[index].equals(orSeparator)){
                
                return is||compare(ev, is, index+1,data)||is;
            }else{
                String [] values=ev[index].split(orSeparator);
                boolean value= Boolean.parseBoolean(((String)data.get(values[0])));
                boolean condition=Boolean.parseBoolean(values[1]);
                return compare(ev,(value||condition)||is, index+1, data);
            }

        }else if(ev[index].contains(equalSeparator)){

            
            String [] values=ev[index].split(equalSeparator);
            String value=(String)data.get(values[0]);
            String condition=values[1];
            return compare(ev, value.equals(condition)&&is, index+1, data);

        }else if(ev[index].contains(greatearSeparator)){

            String [] values=ev[index].split(greatearSeparator);
            int value= Integer.parseInt(((String)data.get(values[0])));
            int condition=Integer.parseInt(values[1]);
            return compare(ev, value>condition&&is, index+1, data);

        }else if(ev[index].contains(lesserSeparator)){

            String [] values=ev[index].split(lesserSeparator);
            int value= Integer.parseInt(((String)data.get(values[0])));
            int condition=Integer.parseInt(values[1]);
            return compare(ev, value<condition&&is, index+1, data);
            
        }else{
            
            
        }
        ;
        return false;
    }


}
