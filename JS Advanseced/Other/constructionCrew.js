function constructionCrew(obj) {
    const newLevelOfHydrated = obj.weight / 10;
    if (obj.dizziness) {
        obj.levelOfHydrated += newLevelOfHydrated * obj.experience;
        obj.dizziness=false;
    }
    return obj
}