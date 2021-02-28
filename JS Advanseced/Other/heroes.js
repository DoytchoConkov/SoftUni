function heroes() {
    const mage = (name) => {
        this.name = name,
            this.health = 100,
            this.mana = 100,
            this.cast = (spell) => {
                console.log(`${this.name} cast ${spell}`);
                this.mana--;
            }
            return this;
    }
    const fighter = (name) => {
        this.name = name,
            this.health = 100,
            this.stamina = 100,
            this.fight = () => {
                console.log(`${this.name} slashes at the foe!`);
                this.stamina--;
            }
        return this;
    }
    return { mage: mage, fighter: fighter }
}

let create = heroes();
const scorcher = create.mage("Scorcher");
scorcher.cast("fireball")
scorcher.cast("thunder")
scorcher.cast("light")

const scorcher2 = create.fighter("Scorcher 2");
scorcher2.fight()

console.log(scorcher2.stamina);
console.log(scorcher.mana);