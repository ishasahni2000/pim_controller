#include <sdbusplus/bus.hpp>
#include <iostream>

int main()
{
    auto bus = sdbusplus::bus::new_default();
    bus.request_name("xyz.openbmc_project.PICService");

    std::cout << "PICService started. (Dummy for now)\n";

  
    while (true)
    {
        bus.process_discard();
        bus.wait();
    }

    return 0;
}

