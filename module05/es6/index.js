let courses = [
    {
        id: 1,
        title: "ReactJS Tutorial",
        rating: 4.2,
    },
    {
        id: 2,
        title: "Angular Tutorial",
        rating: 2.5,
    },
    {
        id: 3,
        title: "VueJS Tutorial",
        rating: 3.8,
    },
    {
        id: 4,
        title: "Java Tutorial",
        rating: 4,
    },
    {
        id: 5,
        title: "JavaScript Tutorial",
        rating: 3.5,
    },
];
// Yeu cau 1
let greaterThan4 = courses.filter(elem => elem.rating >=4)
console.log(greaterThan4);
//Yeu cau 2
let lessThan4 = courses.filter(elem => elem.rating < 4)
let arrLessThan4 = lessThan4.map(elem => `${elem.id}-${elem.title}-${elem.rating}`)
console.log(arrLessThan4)
// Yeu cau 3
let addedCourses = [
    {
        id: 6,
        title: "PHP Tutorial",
        rating: 3,
    },
    {
        id: 7,
        title: "C# Tutorial",
        rating: 2,
    },
    {
        id: 8,
        title: "Docker Tutorial",
        rating: 3.8,
    }
];
let newArr = (x, y) => [...x, ...y];
console.log(newArr(courses, addedCourses));
