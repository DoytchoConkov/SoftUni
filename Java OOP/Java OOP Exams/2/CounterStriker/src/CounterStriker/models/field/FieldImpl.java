package CounterStriker.models.field;

import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.OutputMessages.COUNTER_TERRORIST_WINS;
import static CounterStriker.common.OutputMessages.TERRORIST_WINS;

public class FieldImpl implements Field {
    @Override
    public String start(Collection<Player> players) {

        List<Player> terrorists = new ArrayList<>();
        List<Player> counterTerrorists = new ArrayList<>();
        for (Player player : players) {
            if (player.getClass().getSimpleName().equals("Terrorist")){
                terrorists.add(player);
            }else{
                counterTerrorists.add(player);
            }
        }

        while (terrorists.size() > 0 && counterTerrorists.size() > 0) {

            for (Player terrorist : terrorists) {

                for (Player counterTerrorist : counterTerrorists) {

                    counterTerrorist.takeDamage(terrorist.getGun().fire());

                }

            }

            for (Player counterTerrorist : counterTerrorists) {

                for (Player terrorist : terrorists) {

                    terrorist.takeDamage(counterTerrorist.getGun().fire());

                }


            }
            terrorists = terrorists.stream().filter(t -> t.isAlive() == true).collect(Collectors.toList());
            counterTerrorists = counterTerrorists.stream().filter(t -> t.isAlive() == true).collect(Collectors.toList());

        }

        return terrorists.size() > 0 ? TERRORIST_WINS : COUNTER_TERRORIST_WINS;
    }
}
