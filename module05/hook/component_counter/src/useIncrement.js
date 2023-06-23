import {useState} from "react";

export function useIncrement (addAmount){
    const [count, setCount] = useState(0)
    function increment(addAmount) {
        setCount(addAmount)
    }
    return [count, increment]
}