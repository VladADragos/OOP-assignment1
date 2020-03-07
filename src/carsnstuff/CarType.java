package carsnstuff;

public enum CarType {
    Volvo240,
    Saab95,
    Scania;


    public static String toStr(CarType type){
        switch(type){

            case Volvo240:
                return "Volvo240";
                break;
            case Saab95:
                return "Saab95";
                break;
            case Scania:
                return "Scania";
                break;
        }
    }
}


