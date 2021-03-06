package uk.wanat.theclinick.model;

public enum Speciality {
    ALLERGY("Allergy"), DENTISTRY("Dentistry"), CARDIOLOGY("Cardiology"), DERMATOLOGY("Dermatology"), LARYNGOLOGY("Laryngology"), ENDOCRINOLOGY("Endocrinology"), GYNAECOLOGY("Gynaecology"),
    NEUROLOGY("Neurology"), NURSE("Nurse"), DIETETICS("Dietetics"), OPHTHALMOLOGY("Ophthalmology"), ORTHOPAEDICS("Orthopaedics"), PAEDIATRICS("Paediatrics"), PHYSIOTHERAPY("Physiotherapy"), UROLOGY("Urology"),
    GP("GP"), PSYCHIATRY("Psychiatry"), PSYCHOLOGY("Psychology"), ULTRASOUND("Ultrasound");

    private final String displayValue;

    Speciality(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
