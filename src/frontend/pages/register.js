import React from "react";
import {Container, MuiThemeProvider} from "@material-ui/core";
import DefaultTheme from "../styles/DefaultTheme"
import TopAppBar from "../components/TopAppBar";


const Register = () => {
    return (
        <>
            <MuiThemeProvider theme={DefaultTheme}>
                <TopAppBar/>
                <Container >
                    <p>Hoes</p>
                </Container>
            </MuiThemeProvider>
        </>
    )
}

export default Register