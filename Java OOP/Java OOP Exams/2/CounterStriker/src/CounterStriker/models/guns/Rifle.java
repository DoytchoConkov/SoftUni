package CounterStriker.models.guns;

public class Rifle extends GunImpl{
    private static final int SHOOT=10;

    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (this.getBulletsCount() >= SHOOT) {
            this.setBulletsCount(this.getBulletsCount()-SHOOT);
            return SHOOT;
        }else{
            return 0;
        }
    }
}
