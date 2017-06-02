package com.company;

/**
 * Created by Pavel_Haidzinski on 5/29/2017.
 */
public class Truck {

    private int plates;
    private boolean inprogress;

    public Truck(){
    }

    public Truck(int plates){
        this.plates = plates;
    }

    public int getPlates(){
        return plates;
    }

    public void setPlates(int plates){
        this.plates = plates;
    }

    public boolean isInprogress(){
        return inprogress;
    }

    public void setInprogress(boolean inprogress){
        this.inprogress = inprogress;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + plates;
        result = prime * result + (inprogress ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Truck other = (Truck) obj;
        if(plates != other.plates)
            return false;
        if(inprogress != other.inprogress)
            return false;
        return true;
    }


}
