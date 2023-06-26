import {useState} from "react";

export function useIncrement (initialNumber){
    const [count, setCount] = useState(initialNumber)
    function increment(addAmount) {
        setCount(prevState => prevState+addAmount)
    }
    return [count, increment]
}