export class HelloWorldDto {

    id: number;
    text: string;
    portBe: string;

    constructor(id: number, text: string, portBe: string) {
        this.id = id;
        this.text = text;
        this.portBe = portBe;
    }
    
}