import LoginRequest from "../models/loginResquest";
import TypeService from "./type-service";



export default class AuthentificationService {
  static isAuthenticated: boolean;

  static jwt: string;

  static async getJwt(login: LoginRequest): Promise<any> {
    try {
    const response = await fetch(`http://localhost:8080/auth/signin`, {
        method: 'POST',
        body: JSON.stringify(login),
        headers: { 'Content-Type': 'application/json'}
      });
      if (response.ok) {
        return await response.json();
      } else if (response.status === 401) {
        this.isAuthenticated = false;
      }
  } catch (error) {
    this.isAuthenticated = false;
  }}

  static async login(username: string, password: string): Promise<boolean> {

    await this.getJwt(new LoginRequest(username, password))
        .then(response => this.jwt = response.tokenHeader + ' ' + response.token);

        console.log(this.jwt);

        TypeService.plusTypes();


      const isAuthenticated = this.jwt != undefined
      return new Promise(resolve => {
          setTimeout(() => {
              this.isAuthenticated = isAuthenticated;
              resolve(isAuthenticated);
          }, 1000);

      })
  }

  static handleError(error: Error): void {
    // this.isAuthenticated=false;
    console.error(error);
  }

}

