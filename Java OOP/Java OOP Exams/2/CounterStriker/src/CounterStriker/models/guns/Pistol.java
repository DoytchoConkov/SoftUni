package CounterStriker.models.guns;

public class Pistol extends GunImpl {
    private static final int SHOOT=1;

    public Pistol(String name, int bulletsCount) {
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
