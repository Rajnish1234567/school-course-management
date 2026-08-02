Why you used ArrayList instead of array?
    
    To store the students, courses and enrollments data, I have used arraylist instead of arrays because :-
    
    1. Array size is fixed while Arraylist is dynamic which means it automatically grows if the arraylist size increases
        threshold limit. Arraylist internally uses arrays itself with initialisation with defualt values.

    2. Since arrays size is fixed, so it store the size in a variable named as length while in arraylist there is method 
        to get current size of arraylist.

    3. Arraylist provides different methods which helps to add data, add data at specific index, retrive data of a index,
        check data present in arraylist or not, fetching size of arraylist, removing data from a specific index, removing
        all data from arraylist and so on.

    4. It also helps to store data of any data type using wildcard.

    5. In array to check any data present we have to loop over array and compare each element with target but in arraylist
        there is contains() method which perform this action.

Where you used static members and why?
    
    Static members or class level variables are used to store the properties of class which means if we want to save
    some common data which can be shared between different instance and any instance can change that data, then we can
    use static variables.

    I have also used static member or variables in this project based on the requirement. Like to store the students data
    or courses, I have used static arraylist so that each instance can access the arraylist and save or update data in the
    list.

    Also for some util methods used like generateId for students, courses, I have used static methods so that it can be
    used directly without instanciating it.

    Some variables like studentIdCounter are declared static because this is the class level property so that the data
    can be same across different instances and any change made in this variable reflects to other instances so that
    duplicate id can not be generated because static variable are instanciated only once during linking phase.

Where you used inheritance and what you gained from it?
    
    I have used inheritance in Student class. Here, student class inherit the property of person class. Means the property
    like firstName, lastName, email are the properties that belongs to both person and student. so instead of duplicating
    the code, student class extends the person class and in this way it can access the person class properties.

    some behaviour of person class is like displayDetails() is overridden in student class which tells that the child 
    class can either inherit the property from parent and also can override the parent property.

    Creating the child instance also create its parent instance because the child constructor calls the parent constructor
    internally even it is not written using super() keyword.