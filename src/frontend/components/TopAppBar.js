import {AppBar, Container, Typography} from "@material-ui/core";
import React from "react";

const TopAppBar = () => {
    return (
        <AppBar position={"fixed"} color={"default"}>
            <Container maxWidth={"xl"}>
                <Typography variant={"h2"}>groupsync.</Typography>
            </Container>
        </AppBar>
    )
}
export default TopAppBar
