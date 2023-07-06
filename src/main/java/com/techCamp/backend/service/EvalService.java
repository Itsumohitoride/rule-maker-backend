package com.techCamp.backend.service;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.techCamp.backend.dto.RuleDto;
@Service
public class EvalService {
    private String separator="[()]";
    private String andSeparator="&";
    private String orSeparatorSplit="\\|\\|";
    private String orSeparator="||";
    private String equalSeparator="=";
    private String greatearSeparator=">";
    private String lesserSeparator="<";
    private String greatearEqualSeparator=">=";
    private String lesserEqualSeparator="<=";
    private String diff="!=";


    public EvalService(){

    }


    public boolean evaluate(RuleDto rule,JSONObject data){
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

                boolean [] values=booleanConverter(ev[index], andSeparator, data);
                return compare(ev, values[0]&&values[1], index+1, data);
            }
        }else if(ev[index].contains(orSeparator)){
            
            if(ev[index].equals(orSeparator)){
                return is||compare(ev, is, index+1,data)||is;
            }else{

                boolean [] values=booleanConverter(ev[index], orSeparatorSplit, data);
                return compare(ev, values[0]||values[1], index+1, data);

            }

        }else if(ev[index].contains(greatearSeparator)){

            
            if(ev[index].contains(greatearEqualSeparator)){

                int [] values=intConverter(ev[index], greatearEqualSeparator, data);
                return compare(ev, values[0]>=values[1], index+1, data);

            }else{
    
                int [] values=intConverter(ev[index], greatearSeparator, data);
                return compare(ev, values[0]>values[1], index+1, data);

            }
        }else if(ev[index].contains(lesserSeparator)){
            
            if(ev[index].contains(lesserEqualSeparator)){

                int [] values=intConverter(ev[index], lesserEqualSeparator, data);
                return compare(ev, values[0]<=values[1], index+1, data);

            }else{

                int [] values=intConverter(ev[index], lesserSeparator, data);
                return compare(ev, values[0]<values[1], index+1, data);

            }
        }else if(ev[index].contains(equalSeparator)){
            
            if(ev[index].contains(diff)){

                String [] values=stringConverter(ev[index], diff, data);
                return compare(ev, !values[0].equals(values[1]), index+1, data);

            }else{

                String [] values=stringConverter(ev[index], equalSeparator, data);;
                return compare(ev,values[0].equals(values[1]), index+1, data);
            }
        } else{
            
        }
        ;
        return false;
    }

    public int[] intConverter(String value,String separator,JSONObject data){
        String [] values=value.split(separator);
        int valueInTable= Integer.parseInt(((String)data.get(values[0])));
        int toComparate=Integer.parseInt(values[1]);
        int [] out={valueInTable,toComparate};
        return out;
    }

    public String[] stringConverter(String value,String separator,JSONObject data){
        String [] values=value.split(separator);
        String valueInTable=(String)data.get(values[0]);
        String toComparate=values[1];
        String[] out={valueInTable,toComparate};
        return out;
    }

    public boolean[] booleanConverter(String value,String separator,JSONObject data){
        String [] values=value.split(separator);
        boolean valueInTable= Boolean.parseBoolean(((String)data.get(values[0])));
        boolean toComparate=Boolean.parseBoolean(values[1]);
        boolean[] out={valueInTable,toComparate};
        return out;
    }

    


}
