@Override
public String BuyBestComputer(double budget) {
        List<Computer> collect = computerMap.values()
        .stream()
        .filter(c -> c.getPrice() <= budget)
        .sorted((c1, c2) -> Double.compare(c2.getOverallPerformance(), c1.getOverallPerformance()))
        .limit(1)
        .collect(Collectors.toList());

        if (collect.isEmpty()) {
        throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER, budget));
        }

        Computer computer = collect.get(0);
        computerMap.remove(computer.getId());

        return computer.toString();
        }


