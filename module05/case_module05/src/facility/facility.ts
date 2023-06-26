export interface Facility {
    name: string,
    useArea: number,
    rentalCost: number,
    maximumPeople: number,
    rentalType: string,
}

export interface Villa extends Facility{
    roomStandard: string,
    description: string,
    poolArea: number,
    floorsNumber: number
}
export interface House extends Facility{
    roomStandard: string,
    description: string,
    floorsNumber: number
}
export interface Rooms extends Facility{
    roomStandard: string,
    description: string,
    floorsNumber: number,
    freeService, string
}
