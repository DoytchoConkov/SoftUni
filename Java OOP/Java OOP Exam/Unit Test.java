 @Test
    public void TestConstructor() {
        Garage garage = new Garage();
        assertEquals(0, garage.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestAddComputerWithNull() {
        Garage garage = new Garage();
        garage.addCar(null);
    }

    @Test
    public void TestAddComputerRealComputer() {
        Garage garage = new Garage();
        Car computer = new Car("IBM", 55, 10.00);
        garage.addCar(computer);
        assertEquals(1, garage.getCount());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void TestAddComputerSameComputer() {
        Garage garage = new Garage();
        Car computer = new Car("IBM", 55, 10.00);
        garage.addCar(computer);
        garage.getCars().add(computer);
    }

    @Test
    public void TestRemoveComputerSameComputer() {
        Garage garage = new Garage();
        Car computer = new Car("IBM", 55, 10.00);
        garage.addCar(computer);
        assertNotNull(garage.getCars());
    }

    @Test
    public void TestRemoveComputerInvalidComputer() {
        Garage garage = new Garage();
        Car computer = new Car("IBM", 55, 10.00);
        garage.addCar(computer);
        assertNotNull(garage.findAllCarsWithMaxSpeedAbove(50));
    }

    @Test
    public void TestRemoveComputerInvalidComputer2() {
        Garage garage = new Garage();
        Car computer = new Car("IBM", 55, 10.00);
        garage.addCar(computer);
        assertEquals(computer,garage.getTheMostExpensiveCar());
    }

    @Test
    public void TestRemoveComputerInvalidComputer3() {
        Garage garage = new Garage();
        Car computer = new Car("IBM", 55, 10.00);
        garage.addCar(computer);
        assertNotNull(garage.findAllCarsByBrand("IBM"));
    }