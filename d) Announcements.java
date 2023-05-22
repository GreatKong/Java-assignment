public interface Announcements {
    // Note 1: departure method
    default String departure() {
        return "All Aboard\n";
    }
    
    // Note 2: arrival method
    default String arrival() {
        return " Out\n";
    }
    
    // Note 3: doNotDisturbTheDriver method
    default String doNotDisturbTheDriver() {
        return "No Backseat Driving\n";
    }
}

