export class HelloWorldDto {

    id: number;
    text: string;
    idBe: string;
    portBe: string;

    constructor(id: number, text: string, idBe: string, portBe: string) {
        this.id = id;
        this.text = text;
        this.idBe = idBe;
        this.portBe = portBe;
    }
    
}