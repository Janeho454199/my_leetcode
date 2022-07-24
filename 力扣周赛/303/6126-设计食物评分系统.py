import collections
from typing import List
from sortedcontainers import SortedList


class FoodRatings:

    def __init__(self, foods: List[str], cuisines: List[str], ratings: List[int]):
        n = len(foods)
        self.ind = {food: i for i, food in enumerate(foods)}
        self.foods = foods
        self.cuisines = cuisines
        self.ratings = ratings
        self.cuisine_score = collections.defaultdict(lambda: SortedList())
        for i in range(n):
            self.cuisine_score[cuisines[i]].add([-ratings[i], foods[i]])

    def changeRating(self, food: str, newRating: int) -> None:
        i = self.ind[food]
        self.cuisine_score[self.cuisines[i]].remove([-self.ratings[i], self.foods[i]])
        self.ratings[i] = newRating
        self.cuisine_score[self.cuisines[i]].add([-self.ratings[i], self.foods[i]])

    def highestRated(self, cuisine: str) -> str:
        return self.cuisine_score[cuisine][0][1]


# Your FoodRatings object will be instantiated and called as such:
# obj = FoodRatings(foods, cuisines, ratings)
# obj.changeRating(food,newRating)
# param_2 = obj.highestRated(cuisine)
if __name__ == '__main__':
    foodRatings = FoodRatings(["xxdcg","wfqdeytt","jqmfm","ukqbjikyx","aymciznrnw","qhjjrvr","wzcinxg","ikxj"],["lruhtqy","lruhtqy","lruhtqy","lruhtqy","lruhtqy","lruhtqy","lruhtqy","lruhtqy"],[8,6,1,17,20,2,17,14])
    print(foodRatings.highestRated("korean"))
    print(foodRatings.highestRated("japanese"))
    print(foodRatings.changeRating("sushi", 16))
    print(foodRatings.highestRated("japanese"))
    print(foodRatings.changeRating("ramen", 16))
    print(foodRatings.highestRated("japanese"))
