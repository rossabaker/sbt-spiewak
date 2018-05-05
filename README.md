# sbt-spiewak [![Build Status](https://travis-ci.org/djspiewak/sbt-spiewak.svg?branch=master)](https://travis-ci.org/djspiewak/sbt-spiewak)

This plugin basically just exists to allow me to more conveniently setup my baseline SBT configuration, which has evolved somewhat over the years, and is also becoming quite unwieldy when solely represented in [giter8 format](https://github.com/djspiewak/base.g8). **You probably shouldn't use this plugin.** If you do though, let me know how it works out!

## Usage

Put this in your `plugins.sbt`:

```sbt
resolvers += Resolver.url("djspiewak-sbt-plugins", url("https://dl.bintray.com/djspiewak/sbt-plugins"))(Resolver.ivyStylePatterns)

addSbtPlugin("com.codecommit" % "sbt-spiewak" % "0.1")
```

Then, in your `build.sbt`, make sure you set a value for `baseVersion`:

```sbt
baseVersion := "0.1"
```

Or something like that.

## Features

- Baseline plugin setup
  + coursier
  + sbt-travisci
  + sbt-git
    * With sane git versioning settings
    * Also with fixed `git-status` stuff
  + sbt-header
    * Assumes Apache 2.0 license
  + sbt-bintray
    * With fixed support for Travis builds
  + sbt-pgp
    * Fixes most of the glitches and bugs related to sbt-pgp's setting scoping and default configuration
- Sane scalac settings
- SI-2712 fix across scala versions (dating back to 2.10)
- kind-projector
- `release` and `ci` command aliases
- Hard-coded defaults which assume `com.codecommit` and `Daniel Spiewak` in all the places
  + ...this is totally a feature!