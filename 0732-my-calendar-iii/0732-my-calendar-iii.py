class MyCalendarThree(object):

    def __init__(self):
        from collections import Counter
        self.counter = Counter()
        self.max_count = 0

    def book(self, startTime, endTime):
        """
        :type startTime: int
        :type endTime: int
        :rtype: int
        """
        self.counter[startTime] += 1
        self.counter[endTime] -= 1

       
        current = 0
        max_count = 0
        for time in sorted(self.counter):
            current += self.counter[time]
            max_count = max(max_count, current)
        
        self.max_count = max_count
        return self.max_count

        


# Your MyCalendarThree object will be instantiated and called as such:
# obj = MyCalendarThree()
# param_1 = obj.book(startTime,endTime)