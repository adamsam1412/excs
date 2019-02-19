package com.agh;

public enum  Months {

        JAN("January", false, 1),
        FEB("February", true, 2),
        MAR("March", false, 3),
        APR("April", false, 4),
        MAY("May", true, 5);



        private String name;
        private boolean isShort;
        private int orderNumber;

        Months(String name, boolean isShort, int orderNumber){
            this.name = name;
            this.isShort = isShort;
            this.orderNumber = orderNumber;
        }

        public String toString(){
            return "Months(" +
                    "name= " + name + '\'' +
                    ", isShort=" + isShort +
                    "orderNumber " + orderNumber +
                    ")";
        }


}
