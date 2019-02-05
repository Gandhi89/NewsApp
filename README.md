# NewsApp
This News application explores some features of Android Architecture Components (Paging, LiveData, ViewModel) along with network libraries (Retrofit, picasso) while following MVVM architecture 

# Why paging library?
Android apps that are built today has one same issue: Requesting long data which user may or may not see. One way to solve this problem is listen to scroll of RecyclerView & load more data when user reaches end of RecylerView.
In this approach it was difficult to maintain efficiency, also UI logic & data logic gets complicated which makes debugging & testing of project difficult.

`The Paging Library makes it easier for you to load data gradually and gracefully within your app's RecyclerView.`

**Several advantages of using Paging Library are:**
1. Data requests consume less network bandwidth and fewer system resources. Users who have metered or small data plans appreciate such data-conscious apps.
2. Even during data updates and refreshes, the app continues to respond quickly to user input.

# How paging library works?
