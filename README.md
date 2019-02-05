# NewsApp
This News application explores some features of Android Architecture Components (Paging, LiveData, ViewModel) along with network libraries (Retrofit, picasso) while following MVVM architecture 

![](https://github.com/Gandhi89/NewsApp/blob/master/newsApp.gif)

# Why paging library?
Android apps that are built today has one same issue: Requesting long data which user may or may not see. One way to solve this problem is listen to scroll of RecyclerView & load more data when user reaches end of RecylerView.
In this approach it was difficult to maintain efficiency, also UI logic & data logic gets complicated which makes debugging & testing of project difficult.

`The Paging Library makes it easier for you to load data gradually and gracefully within your app's RecyclerView.`

**Several advantages of using Paging Library are:**
1. Data requests consume less network bandwidth and fewer system resources. Users who have metered or small data plans appreciate such data-conscious apps.
2. Even during data updates and refreshes, the app continues to respond quickly to user input.

# paging library components 

**DataSource**

Datasource is the base class for loading data. There is the various way to load data into your list, you can use it by extending any one of its 3 subclasses and these are

* **PageKeyedDataSource**
* **ItemKeyedDataSource**
* **PositionalDataSource**

**PagedList**

PagedList is a wrapper list that holds your data items and tells the DataSource when to load the elements or you can say it is a list which loads its data in chunks (pages) from a DataSource. Items can be accessed with get(int) and further loading can be triggered with loadAround(int). To display data from PagedList we will use PagedListAdapter. 
Creating PagedList loads the first chunk of data from the DataSource immediately, and should, for this reason, loading be done on a background thread.`PagedList.Config` is used to control when and how many items PagedList loads.

**PagedListAdapter**

This class is responsible for presenting data loaded by PagedList and it is the implementation of RecyclerView.adapter. It uses DiffUtil as a parameter to calculate data differences and do all the updates for you.
when a new page is loaded, the PagedListAdapter signals the RecyclerView that the new data has arrived, this lets the RecyclerView replace any placeholders with the actual items.

![](https://github.com/Gandhi89/NewsApp/blob/master/paging.png)

# Demonstration

![](https://github.com/Gandhi89/NewsApp/blob/master/newsApp.gif)

