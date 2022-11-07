export default class JwtResponse {
    token: string;
    tokenHeader: string;

    constructor(
        token: string,
        tokenHeader: string
    ) {

        this.token = token;
        this.tokenHeader = tokenHeader;   
    }
}