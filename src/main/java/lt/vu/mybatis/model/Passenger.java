package lt.vu.mybatis.model;

public class Passenger {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.PASSENGER.ID
     *
     * @mbg.generated Tue Apr 21 06:10:25 EEST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.PASSENGER.FIRST_NAME
     *
     * @mbg.generated Tue Apr 21 06:10:25 EEST 2020
     */
    private String firstName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.PASSENGER.LAST_NAME
     *
     * @mbg.generated Tue Apr 21 06:10:25 EEST 2020
     */
    private String lastName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.PASSENGER.ID
     *
     * @return the value of PUBLIC.PASSENGER.ID
     *
     * @mbg.generated Tue Apr 21 06:10:25 EEST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.PASSENGER.ID
     *
     * @param id the value for PUBLIC.PASSENGER.ID
     *
     * @mbg.generated Tue Apr 21 06:10:25 EEST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.PASSENGER.FIRST_NAME
     *
     * @return the value of PUBLIC.PASSENGER.FIRST_NAME
     *
     * @mbg.generated Tue Apr 21 06:10:25 EEST 2020
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.PASSENGER.FIRST_NAME
     *
     * @param firstName the value for PUBLIC.PASSENGER.FIRST_NAME
     *
     * @mbg.generated Tue Apr 21 06:10:25 EEST 2020
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.PASSENGER.LAST_NAME
     *
     * @return the value of PUBLIC.PASSENGER.LAST_NAME
     *
     * @mbg.generated Tue Apr 21 06:10:25 EEST 2020
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.PASSENGER.LAST_NAME
     *
     * @param lastName the value for PUBLIC.PASSENGER.LAST_NAME
     *
     * @mbg.generated Tue Apr 21 06:10:25 EEST 2020
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}