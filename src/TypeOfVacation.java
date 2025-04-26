public enum TypeOfVacation {
    BUSINESS, PRIVATE, STUDY;

    @Override
    public String toString() {

        if (this==TypeOfVacation.BUSINESS) {
            return "Obchodní";
        } else if (this==TypeOfVacation.PRIVATE){
            return "Privátní";
        } else if (this==TypeOfVacation.STUDY){
                return "Studijní";
        } else {
            return "neznámý";
        }


    }
}
