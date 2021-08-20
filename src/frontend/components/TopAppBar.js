import React from "react";
import {AppBar, Container, Typography} from "@material-ui/core";

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
